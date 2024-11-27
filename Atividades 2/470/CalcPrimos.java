public class CalcPrimos {
    public int primo(int numero) {
        if (numero <= 1) {
            return 1;
        }

        int divisor = 2;
        while (divisor <= numero / 2) {
            
            if (numero % divisor == 0) {
                return 1;
            }
            
            divisor++;
        }
        
        return 0; 
    }
}
