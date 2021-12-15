package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.CoinModel;
import vendingmachine.model.ItemModel;
import vendingmachine.model.UserModel;
import vendingmachine.validator.InputValidator;
import vendingmachine.validator.QueryValidator;
import vendingmachine.view.VendingMachineOutputView;

public class VendingMachineController {
	private final static VendingMachineController vendingMachineController = new VendingMachineController();

	private final VendingMachineOutputView vendingMachineOutputView;
	private final InputValidator inputValidator;
	private final QueryValidator queryValidator;
	private final CoinModel coinModel;
	private final ItemModel itemModel;
	private final UserModel userModel;

	private VendingMachineController() {
		vendingMachineOutputView = VendingMachineOutputView.getVendingMachineOutputView();
		inputValidator = InputValidator.getInputValidator();
		coinModel = CoinModel.getCoinModel();
		itemModel = ItemModel.getItemModel();
		userModel = UserModel.getUserModel();
		queryValidator = QueryValidator.getQueryValidator();
	}

	public static VendingMachineController getVendingMachineController() {
		return vendingMachineController;
	}

	public void run() {
		coinModel.generateCoins(getInitialAmount());
		showCoinsVendingMachineHave();
		itemModel.createItems(getInitialItems());
		userModel.putMoney(getInputAmount());
		buyItems();
		giveChange();
	}

	private String getInitialAmount() {
		String amount;
		do {
			vendingMachineOutputView.printAmountInputMessage();
			amount = Console.readLine();
		} while (canNotUseInputAsInitialAmount(amount));
		return amount;
	}

	private boolean canNotUseInputAsInitialAmount(String initialAmount) {
		try {
			inputValidator.checkAllInitialAmountInputExceptions(initialAmount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
		return false;
	}

	private void showCoinsVendingMachineHave() {
		vendingMachineOutputView.printVendingMachineInitialCoinsOutputMessage();
		vendingMachineOutputView.printVendingMachineCoins(coinModel.getNumberOfCoins());
	}

	private String getInitialItems() {
		String items;
		do {
			vendingMachineOutputView.printInitialItemsInputMessage();
			items = Console.readLine();
		} while (canNotUseInputAsItems(items));
		return items;
	}

	private boolean canNotUseInputAsItems(String items) {
		try {
			inputValidator.checkAllInitialItemsInputExceptions(items);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
		return false;
	}

	private String getInputAmount() {
		String inputAmount;
		do {
			vendingMachineOutputView.printUserInputAmountInputMessage();
			inputAmount = Console.readLine();
		} while (canNotUseInputAsAmount(inputAmount));
		return inputAmount;
	}

	private boolean canNotUseInputAsAmount(String inputAmount) {
		try {
			inputValidator.checkAllInputAmountInputExceptions(inputAmount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
		return false;
	}

	private void buyItems() {
		while (canBuyItem()) {
			buyItem();
		}
	}

	private boolean canBuyItem() {
		return itemModel.getMinimumPrice() <= userModel.getRemainingMoney() && itemModel.hasStock();
	}

	private void buyItem() {
		vendingMachineOutputView.printRemainingAmount(userModel.getRemainingMoney());
		vendingMachineOutputView.printPurchasingInputMessage();
		String item = Console.readLine();
		if (canNotBuyItemByItemName(item))
			return;
		itemModel.sellItem(item);
		userModel.reduceMoney(itemModel.getPriceByName(item));
	}

	private boolean canNotBuyItemByItemName(String item) {
		try {
			queryValidator.checkAllBuyItemErrorExceptions(userModel.getRemainingMoney(),
					itemModel.getPriceByName(item));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void giveChange() {
		vendingMachineOutputView.printRemainingAmount(userModel.getRemainingMoney());
		vendingMachineOutputView.printChangeOutputMessage();
		vendingMachineOutputView.printVendingMachineCoins(
				coinModel.getMinimumNumberCoins(userModel.getRemainingMoney()));
	}
}
