package cn.edu.bjut.software.test.part2;

public class MetroSaleTicket {
    private int inputTotalMoney=0,countOfOneYuan;
    //��������ĵ���·�ߵġ����͡���A�� 2Ԫ B�� 4Ԫ
    private String[] typeOfTickets={"TypeA","TypeB"};
    private String resultOfDeal;
    public MetroSaleTicket()
    {
        initial();
    }

    private void initial()
    {
        countOfOneYuan=100;      //1Ԫ����������ʼΪ100��
    }

    public MetroSaleTicket(int oneYuan)
    {
        countOfOneYuan=oneYuan;
    }

    public String currentState()   //��ǰ״̬
    {
        String state = "Current State\n"+"1 Yuan:"+countOfOneYuan;
        return state;
    }

    public String operation(String type,String money)
    //type���û�ѡ���·�����ͣ�money���û�Ͷ�ҵ�����
    {
        if(money.equalsIgnoreCase("1yuan")) //��Ͷ��1Ԫ
        {
            inputTotalMoney=inputTotalMoney+1;
            countOfOneYuan=countOfOneYuan+1;
        }
        else if(money.equalsIgnoreCase("5yuan"))  //��Ͷ��5Ԫ
        {
            inputTotalMoney=inputTotalMoney+5;
        }
        else if(money.equalsIgnoreCase("10yuan")) //��Ͷ��10Ԫ
        {
            inputTotalMoney=inputTotalMoney+10;
        }
        else //Ǯ����������
        {
            resultOfDeal="Failure Information\n"+"Money Error";
            return resultOfDeal;
        }
        if(inputTotalMoney<2)
        {
            resultOfDeal="Not enough money!";  //Ͷ������2Ԫ������Ǯ����
            return resultOfDeal;
        }
        else if(type.equals(typeOfTickets[0])&&(countOfOneYuan>=
                inputTotalMoney-2))    //��ѡ��A��Ʊ��ϵͳ�㹻����
        {
            countOfOneYuan=countOfOneYuan-(inputTotalMoney-2);
            resultOfDeal="Input Information\n"+"Type:A;Money:2Yuan\n"+currentState();
            return resultOfDeal;
        }
        else if(type.equals(typeOfTickets[0])&&(countOfOneYuan<
                inputTotalMoney-2))      //��ѡ��A��Ʊ��ϵͳ��������
        {
            resultOfDeal="Not enough Change!";
            return resultOfDeal;
        }
        else if(type.equals(typeOfTickets[1])&&(inputTotalMoney<4))
        {
            resultOfDeal="Not enough Money"; //��ѡ��B��Ʊ��Ͷ������4Ԫ������Ǯ����
            return resultOfDeal;
        }
        else if(type.equals(typeOfTickets[1])&&(countOfOneYuan>=
                inputTotalMoney-4))   //��ѡ��B��Ʊ��ϵͳ�㹻����
        {
            countOfOneYuan=countOfOneYuan-(inputTotalMoney-4);
            resultOfDeal="Input Information\n"+
                    "Type:B;Money:4Yuan\n"+currentState();
            return resultOfDeal;
        }
        else if(type.equals(typeOfTickets[1])&&
                (countOfOneYuan<inputTotalMoney-4))
        //��ѡ��B��Ʊ��ϵͳ��������
        {
            resultOfDeal="Not enough Change!";
            return resultOfDeal;
        }
        else
        {//Ʊ�����Ͳ���ȷ
            resultOfDeal="Failure Information\n"+"Type Error";
            return resultOfDeal;
        }
    }
}

