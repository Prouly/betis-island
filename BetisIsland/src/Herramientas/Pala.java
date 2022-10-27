package Herramientas;

public class Pala extends Herramienta {

    
    public Pala() {
        super();
       
    }

    @Override
    public String toString() {
        return "Pala: Posicion X: " + posicionX + " | Posicion Y: " + posicionY;
    }
    
    public String verPala() {
        return    "   *#%%&&                                        \r\n"
                + "  /#%&    &&                                      \r\n"
                + " (%&       #%                                     \r\n"
                + "   %&%     ((                                     \r\n"
                + "        &#((#                                   \r\n"
                + "             *.,,.                                \r\n"
                + "                ,.,,                              \r\n"
                + "                  ,.,,                            \r\n"
                + "                     ,.,,                         \r\n"
                + "                       ,(&&#                      \r\n"
                + "                         (#&&%                    \r\n"
                + "                            &&&&                  \r\n"
                + "                               &%&/    #%%        \r\n"
                + "                                 &%(&&%%%%%%%     \r\n"
                + "                                 ,%%&##%%%#####/  \r\n"
                + "                               (%&&&%%%%#%%%##%%% \r\n"
                + "                                 &&&&&&&%%&%%%%%%%\r\n"
                + "                                    &&&&&&&&&%%%%%\r\n"
                + "                                      &&&&&&&&%%%%";
    }

}