package cn.edu.bjut.software.test.part2;

public class MetroSaleTicket {
    private int inputTotalMoney=0,countOfOneYuan;
    //定义允许的地铁路线的“类型”：A类 2元 B类 4元
    private String[] typeOfTickets={"TypeA","TypeB"};
    private String resultOfDeal;
    public MetroSaleTicket()
    {
        initial();
    }

    private void initial()
    {
        countOfOneYuan=100;      //1元的数量，初始为100个
    }

    public MetroSaleTicket(int oneYuan)
    {
        countOfOneYuan=oneYuan;
    }

    public String currentState()   //当前状态
    {
        String state = "Current State\n"+"1 Yuan:"+countOfOneYuan;
        return state;
    }

    public String operation(String type,String money)
    //type是用户选择的路线类型，money是用户投币的种类
    {
        if(money.equalsIgnoreCase("1yuan")) //若投入1元
        {
            inputTotalMoney=inputTotalMoney+1;
            countOfOneYuan=countOfOneYuan+1;
        }
        else if(money.equalsIgnoreCase("5yuan"))  //若投入5元
        {
            inputTotalMoney=inputTotalMoney+5;
        }
        else if(money.equalsIgnoreCase("10yuan")) //若投入10元
        {
            inputTotalMoney=inputTotalMoney+10;
        }
        else //钱的类型有误
        {
            resultOfDeal="Failure Information\n"+"Money Error";
            return resultOfDeal;
        }
        if(inputTotalMoney<2)
        {
            resultOfDeal="Not enough money!";  //投入少于2元，返回钱不足
            return resultOfDeal;
        }
        else if(type.equals(typeOfTickets[0])&&(countOfOneYuan>=
                inputTotalMoney-2))    //若选择A类票且系统足够找零
        {
            countOfOneYuan=countOfOneYuan-(inputTotalMoney-2);
            resultOfDeal="Input Information\n"+"Type:A;Money:2Yuan\n"+currentState();
            return resultOfDeal;
        }
        else if(type.equals(typeOfTickets[0])&&(countOfOneYuan<
                inputTotalMoney-2))      //若选择A类票且系统不够找零
        {
            resultOfDeal="Not enough Change!";
            return resultOfDeal;
        }
        else if(type.equals(typeOfTickets[1])&&(inputTotalMoney<4))
        {
            resultOfDeal="Not enough Money"; //若选择B类票且投入少于4元，返回钱不足
            return resultOfDeal;
        }
        else if(type.equals(typeOfTickets[1])&&(countOfOneYuan>=
                inputTotalMoney-4))   //若选择B类票且系统足够找零
        {
            countOfOneYuan=countOfOneYuan-(inputTotalMoney-4);
            resultOfDeal="Input Information\n"+
                    "Type:B;Money:4Yuan\n"+currentState();
            return resultOfDeal;
        }
        else if(type.equals(typeOfTickets[1])&&
                (countOfOneYuan<inputTotalMoney-4))
        //若选择B类票且系统不够找零
        {
            resultOfDeal="Not enough Change!";
            return resultOfDeal;
        }
        else
        {//票的类型不正确
            resultOfDeal="Failure Information\n"+"Type Error";
            return resultOfDeal;
        }
    }
}

