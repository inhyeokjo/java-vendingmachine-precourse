package vendingmachine.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CoinStorage {
	public static final List<Integer> MONETARY_UNIT_LIST = Arrays.stream(Coin.values())
		.map(Coin::getAmount)
		.collect(Collectors.toList());

	private static final CoinStorage coinStorage = new CoinStorage();

	private List<Coin> coins = new ArrayList<>();

	private CoinStorage() {
	}

	public static CoinStorage getCoinStorage() {
		return coinStorage;
	}

	public void createCoin(int amount) {
		coins.add(Coin.getCoinFromAmount(amount));
	}

	public List<Integer> getNumberOfCoins() {
		return Arrays.stream(Coin.values())
			.map(this::getNumberOfCoin)
			.collect(Collectors.toList());
	}

	public int getNumberOfMonetaryUnitType() {
		return MONETARY_UNIT_LIST.size();
	}

	private int getNumberOfCoin(Coin coin) {
		return Collections.frequency(coins, coin);
	}
}
