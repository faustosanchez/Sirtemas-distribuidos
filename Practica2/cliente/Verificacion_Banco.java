
import java.io.*;

public class Verificacion_Banco {
    float monto;
    int status;
    int tarjeta;
    int cvv;
    int boleano;
    Verificacion_Banco()
    {
        this.status=5000;//Status del banco
        this.monto=0;
        this.tarjeta=0;
        this.cvv=0;
        this.boleano=0;
    }
    int checar_saldo (float m,int t,int cvv)
    {
        int salida=0;   
        if(t == 123456)
        {
            if(cvv==123)
            {
                if(monto<=this.status)
                {
                    salida=1;
                }
            }
        }
        return salida;

        
    }

    public int pago (float m,int t,int cvv)
    {
        
        this.monto=m;
        this.tarjeta=t;
        this.cvv=cvv;
        boleano=checar_saldo(this.monto,this.tarjeta,this.cvv);
        return boleano;
    }

}