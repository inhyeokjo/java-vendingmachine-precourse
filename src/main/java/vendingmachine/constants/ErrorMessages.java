package vendingmachine.constants;

public class ErrorMessages {
	public static final String EMPTY_INPUT_ERROR_MESSAGE = "[ERROR] 빈칸을 입력하실 수 없습니다.";
	public static final String MONEY_NOT_NATURAL_NUMBER_ERROR_MESSAGE = "[ERROR] 금액은 자연수여야 합니다.";
	public static final String MONEY_NOT_MULTIPLICATION_OF_TEN_ERROR_MESSAGE = "[ERROR] 보유한 금액은 10의 배수여야 합니다.";
	public static final String NOT_SATISFIED_INPUT_FORMAT_ERROR_MESSAGE = "[ERROR] [상품명,가격,수량];[상품명,가격,수량]의 형식을 맞춰서 입력해주세요.";
	public static final String ITEM_ARGUMENT_LACK_ERROR_MESSAGE = "[ERROR] [상품평,가격,수량] 3항목 입력해주세요.";
	public static final String PRICE_NOT_NATURAL_NUMBER_ERROR_MESSAGE = "[ERROR] 상품의 가격은 자연수여야 합니다.";
	public static final String PRICE_NOT_MULTIPLICATION_OF_TEN_ERROR_MESSAGE = "[ERROR] 상품의 가격은 10의 배수여야 합니다.";
	public static final String PRICE_UNDER_100_ERROR_MESSAGE = "[ERROR] 상품의 가격은 100원 이상이어야 합니다.";
	public static final String QUANTITY_NOT_NATURAL_NUMBER_ERROR_MESSAGE = "[ERROR] 상품의 수량은 자연수여야 합니다.";
	public static final String INPUT_AMOUNT_NOT_MULTIPLICATION_OF_TEN_ERROR_MESSAGE = "[ERROR] 투입금액은 10의 배수여야 합니다.";
	public static final String INPUT_AMOUNT_NOT_NATURAL_NUMBER_ERROR_MESSAGE = "[ERROR] 투입금액은 자연수여야 합니다.";
	public static final String DONT_EXISTING_ITEM_ERROR_MESSAGE = "[ERROR] 존재하지 않는 상품명입니다.";
	public static final String DONT_HAVE_ENOUGH_MONEY_ERROR_MESSAGE = "[ERROR] 돈이 부족합니다.";
}
