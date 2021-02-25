import static java.lang.Math.sqrt;

public class second_degree_1var {
    private double a;
    private double b;
    private double c;

    public void setA(double a) { this.a = a; }
    public void setB(double b) { this.b = b; }
    public void setC(double c) { this.c = c; }

    public void calculate(){
        if(a==0){
            first_degree_1var eq1 = new first_degree_1var();
            eq1.setA(b);
            eq1.setB(c);
            eq1.calculate();
        }
        else{
            double delta = b*b - 4*a*c;
            if(delta <0 ) System.out.println("No solution\n");
            else if (delta == 0) System.out.println("Double root, x1 = x2 = " +-b/(2*a));
            else {
                System.out.println("2 solutions:");
                System.out.println("x1 = "+(-b+sqrt(delta))/(2*a));
                System.out.println("x2 = "+(-b-sqrt(delta))/(2*a));
            }
        }
    }
}
