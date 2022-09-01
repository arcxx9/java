package view;

public class ControllerInserimento {
	
	public static boolean eUnNumero(String str)
    {
      try
      {
        double d = Double.parseDouble(str);
      }
      catch(NumberFormatException nfe)
      {
        return false;
      }
      return true;
    }
   
    public static boolean eVuota(String str) {
        if ( (str.equals(null) || (str.equals(""))) )
            return true;
            else
                return false;
    }

}
