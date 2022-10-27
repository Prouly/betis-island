package Herramientas;

public class Espada extends Herramienta{
    
    public Espada() {
        super();
       
    }

    @Override
    public String toString() {
        return "Espada: Posicion X: " + posicionX + " | Posicion Y: " + posicionY;
    }
    
    public String verEspada() {
        return "  .                                                                             \r\n"
                + "   ((&&                                                                         \r\n"
                + "    ,(&&&&&&&                                                                   \r\n"
                + "       ((&&&&&%&%(                                                              \r\n"
                + "         #(&&&&&&&%%%                                                           \r\n"
                + "            #(#%&%%%%&%%                                                        \r\n"
                + "                /(#%&%%%%%%%                                                    \r\n"
                + "                    (((%%%&%%%%%                                                \r\n"
                + "                        /((%%%%%%%%%#                                           \r\n"
                + "                             (((%%%%%%%%%*                                      \r\n"
                + "                                  (((%%%%%%%%%%                                 \r\n"
                + "                                       ((((%%%%%%%%%        &&                  \r\n"
                + "                                            .((#%%%%%%%%%%@@&@                  \r\n"
                + "                                                  ((((%%%%&@&(                  \r\n"
                + "                                                        ##%@&//(/(,             \r\n"
                + "                                                         ,@@&   &&*///          \r\n"
                + "                                                          @@&@      (&///(@&&   \r\n"
                + "                                                          @@@@&         @&&(*   \r\n"
                + "                                                           (@@@@@&%   &&&/(*/*( \r\n"
                + "                                                              @@@@@@@@    @&%&  \r\n"
                + "                                                                                ";
    }
    
}
