package cn.edu.bjut.software.test.part1;

public class SaleMachine {
	private int countOfBeer, countOfOrangeJuice, countOfFiveCents, countOfOneDollar;
	private String[] typeOfGoods = { "Beer", "OrangeJuice" };
	private String resultOfDeal;

	public SaleMachine() {
		initial();
	}

	private void initial() {
		countOfBeer = 6;
		countOfOrangeJuice = 6;
		countOfFiveCents = 6;
		countOfOneDollar = 6;
	}

	public SaleMachine(int fiveCents, int oneDollar, int numOfBeer, int numOfOrange)
	// 便于测试的初始化函数
	{
		countOfFiveCents = fiveCents;
		countOfOneDollar = oneDollar;
		countOfBeer = numOfBeer;
		countOfOrangeJuice = numOfOrange;
	}

	public String currentState() {
		String state = "Current State\n" +
				"Beer:" + countOfBeer + "\n" +
				"Orange Juice:"+ countOfOrangeJuice + "\n" +
				"5 Cents:" + countOfFiveCents + "\n" +
				"1 Dollar:"+ countOfOneDollar;
		return state;
	}

	public String operation(String type, String money)
	// type是用户选择的产品，money是用户投币种类
	{
		if (money.equalsIgnoreCase("5C")) // 如果用户投入5角钱
		{
			if (type.equals(typeOfGoods[0])) // 如果用户选择啤酒
			{
				if (countOfBeer > 0) // 如果还有啤酒
				{
					countOfBeer--;
					countOfFiveCents++;
					resultOfDeal = "Input Information\n" + "Type: Beer;  Money: 5 Cents;  Change: 0\n\n"
							+ currentState();
					return resultOfDeal;
				} else {
					resultOfDeal = "Failure Information\n" + "Beer Shortage";
					return resultOfDeal;
				}
			} else if (type.equals(typeOfGoods[1])) // 如果用户选择橙汁
			{
				if (countOfOrangeJuice > 0) {
					countOfOrangeJuice--;
					countOfFiveCents++;
					resultOfDeal = "Input Information\n" + "Type: OrangeJuice;   Money: 5 Cents;   Change: 0\n\n"
							+ currentState();
					return resultOfDeal;
				} else {
					resultOfDeal = "Failure Information\n" + "OrangeJuice Shortage";
					return resultOfDeal;
				}
			} else {
				resultOfDeal = "Failure Information\n" + "Type Error";
				return resultOfDeal;
			}
		} else if (money.equalsIgnoreCase("1D")) // 如果用户投入一元钱
		{
			if (countOfFiveCents > 0) // 如果有零钱找
			{
				if (type.equals(typeOfGoods[0]) && countOfBeer > 0) // 如果用户选择啤酒且还有啤酒
				{
					countOfBeer--;
					countOfFiveCents--;
					countOfOneDollar++;
					resultOfDeal = "Input Information\n" + "Type: Beer;   Money: 1 Dollar;   Change: 5 Cents\n\n"
							+ currentState();
					return resultOfDeal;
				} else if (type.equals(typeOfGoods[1]) && countOfOrangeJuice > 0)
				// 如果用户选择橙汁且还有橙汁
				{
					countOfOrangeJuice--;
					countOfFiveCents--;
					countOfOneDollar++;
					resultOfDeal = "Input Information\n" + "Type: OrangeJuice;  Money: 1 Dollar;  Change: 5 Cents\n\n"
							+ currentState();
					return resultOfDeal;
				} else {
					if (type.equals(typeOfGoods[0]) && countOfBeer <= 0) {
						resultOfDeal = "Failure Information\n" + "Beer Shortage";
						return resultOfDeal;
					} else if (type.equals(typeOfGoods[1]) && countOfOrangeJuice <= 0) {
						resultOfDeal = "Failure Information\n" + "OrangeJuice Shortage";
						return resultOfDeal;
					} else {
						resultOfDeal = "Failure Information\n" + "Type Error";
						return resultOfDeal;
					}
				}
			} else {
				resultOfDeal = "Failure Information\n" + "Change Shortage";
				return resultOfDeal;
			}
		} else {
			resultOfDeal = "Failure Information\n" + "Money Error";
			return resultOfDeal;
		}
	}
}



