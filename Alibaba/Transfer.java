package Alibaba;


/**
 * Created by zhensheng on 2016/4/20.
 */

class AliAccount implements Cloneable{
    public static AliAccount alipay ;

    private int countID ;
    private double money;
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getCountID() {
        return countID;
    }

    public void setCountID(int countID) {
        this.countID = countID;
    }

    AliAccount(int c , double m){
        this.countID = c;
        this.money = m ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AliAccount that = (AliAccount) o;

        if (countID != that.countID) return false;
        return Double.compare(that.money, money) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = countID;
        temp = Double.doubleToLongBits(money);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    protected AliAccount clone() throws CloneNotSupportedException {
        return (AliAccount) super.clone();
    }
}

public class Transfer implements Runnable{
    public AliAccount getTransferout() {
        return transferout;
    }

    public void setTransferout(AliAccount transferout) {
        this.transferout = transferout;
    }



    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public AliAccount getTransferin() {
        return transferin;
    }

    public void setTransferin(AliAccount transferin) {
        this.transferin = transferin;
    }
    private AliAccount transferout ;
    private AliAccount transferin ;
    private double amount;

    @Override
    public void run() {
        doTransferOut();
        try {
            this.wait();
            doTransferIn();
        } catch (InterruptedException e) {
            e.printStackTrace();
            doTransferback();
        }

    }
    /*
    queren shouhuo
     */
    public void confirm(){
        this.notifyAll();
    }

    public Transfer(AliAccount out, AliAccount in , double amount){
        this.transferout = out;
        this.transferin= in;
        this.amount = amount;
    }

    public synchronized boolean doTransfer(){

        if(this.transferout.getMoney() < this.amount)
            return false;
        else {
            doTransferOut();
            doTransferIn();
            return true;
        }
    }
    public synchronized boolean doTransferIn(){
        AliAccount.alipay.setMoney(AliAccount.alipay.getMoney()- this.amount);
        this.transferin.setMoney(this.transferin.getMoney()+this.amount);
        return true;
    }

    public synchronized boolean doTransferOut(){
        this.transferout.setMoney(this.transferout.getMoney()- this.amount);
        AliAccount.alipay.setMoney(AliAccount.alipay.getMoney()+ this.amount);
        return true;
    }
    public synchronized boolean doTransferback(){
        AliAccount.alipay.setMoney(AliAccount.alipay.getMoney()- this.amount);
        this.transferout.setMoney(this.transferout.getMoney()+this.amount);
        return true;
    }


}
