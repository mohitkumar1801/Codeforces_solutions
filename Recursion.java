class Recursion
{
    public static void main(String[] args) {
        nto1(5);
    }
    static void nto1(int n)
    {
        if(n==0)
        {
            return;
        }
        nto1(n-1);
        System.out.println(n);
    }
}