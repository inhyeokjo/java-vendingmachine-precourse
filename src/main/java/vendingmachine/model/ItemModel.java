package vendingmachine.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.resource.ItemStorage;

public class ItemModel {
	private final static ItemModel itemModel = new ItemModel();

	private ItemStorage itemStorage;

	private ItemModel() {
		itemStorage = ItemStorage.getItemStorage();
	}

	public static ItemModel getItemModel() {
		return itemModel;
	}

	public void createItems(String stringItemList) {
		List<String> itemList = parseItemStringIntoItemList(stringItemList);
		for (int i = 0; i < itemList.size() / 3; i++) {
			String name = itemList.get(i * 3);
			int price = Integer.parseInt(itemList.get(i * 3 + 1));
			int quantity = Integer.parseInt(itemList.get(i * 3 + 2));
			itemStorage.creatItem(name, price, quantity);
		}
	}

	public int getMinimumPrice() {
		return itemStorage.getPriceList().stream()
			.mapToInt(Integer::intValue)
			.min()
			.getAsInt();
	}

	public boolean hasExtraQuantity() {
		return itemStorage.getQuantityList().stream()
			.mapToInt(Integer::intValue)
			.sum() > 0;
	}

	public int getPriceByName(String name) {
		return itemStorage.getPriceByName(name);
	}

	private List<String> parseItemStringIntoItemList(String items) {
		return Arrays.stream(items.split(";"))
			.map(item -> item.substring(1, item.length() - 1))
			.map(itemElement -> itemElement.split(","))
			.flatMap(Arrays::stream)
			.collect(Collectors.toList());
	}
}
