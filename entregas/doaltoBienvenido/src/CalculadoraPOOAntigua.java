import java.util.Scanner;

public class main 
{

	public static void main(String[] args) 
	{
		Scanner objeto = new Scanner(System.in);
		calculadora operacion = new calculadora();
		boolean volver = true;
		String respuesta;
		
		
		System.out.println("-------------------------------");
		System.out.println("¡¡Bienvenido a la calculadora!!");
		System.out.println("-------------------------------");
		System.out.println();
		
		do
		{
			System.out.println("Introduzca la operacion deseada: ");
			System.out.println("1.Suma.");
			System.out.println("2.Resta.");
			System.out.println("3.Multiplicacion.");
			System.out.println("4.Division.");
			System.out.println("5.Factorial.");
			System.out.println("6.Borrar Memoria.");
			int seleccion = objeto.nextInt();
			
			if(seleccion == 1)
			{
				System.out.println("Introduzca el valor: ");
				float num1 = objeto.nextFloat();
				operacion.suma(num1);
				System.out.println("El resultado es: " + operacion.memoria);
				
			}
			else if(seleccion == 2)
			{
				System.out.println("Introduzca el valor: ");
				float num1 = objeto.nextFloat();
				operacion.resta(num1);
				System.out.println("El resultado es: " + operacion.memoria);
			}
			else if(seleccion == 3)
			{
				System.out.println("Introduzca el valor: ");
				float num1 = objeto.nextFloat();
				operacion.multiplicacion(num1);
				System.out.println("El resultado es: " + operacion.memoria);
			}
			else if(seleccion == 4)
			{
				System.out.println("Introduzca el valor: ");
				float num1 = objeto.nextFloat();
				operacion.division(num1);
				System.out.println("El resultado es: " + operacion.memoria);
			}
			else if(seleccion == 5)
			{
				System.out.println("Introduzca el valor: ");
				int num1 = objeto.nextInt();
				operacion.factorial(num1);
				System.out.println("El resultado es: " + operacion.memoria);
			}
			else if(seleccion == 6)
			{
				System.out.println("¡¡Memoria borrada!!");
				operacion.borrar();
			}
			else
			{
				System.out.println("¡¡Operacion Inexistente!!");
			}
			
			System.out.println();
	        System.out.println("¿Quieres realizar otra operacion? (si/no)");
	        respuesta = objeto.next(); 
	        volver = respuesta.equals("si");  
	         
	         
		}
		while(volver);
		
		 System.out.println();
	     System.out.println("¡¡Adios!!");
	}

}

public class calculadora 
{
	public float memoria = 0;
	
	public void suma(float num1)
	{
		memoria = memoria + num1; 
	}
	
	public void resta(float num1)
	{
		memoria = memoria - num1;
	}
	
	public void multiplicacion(float num1)
	{
		
		memoria = memoria * num1;
	}
	
	public void division(float num1)
	{
		if(num1 == 0)
		{
			System.out.println("¡¡No se puede dividir entre 0!!");
			memoria = 0;
			
		}
		else
		{
			memoria = memoria / num1;		
		}
	}
	public void factorial(int num1) 
	{
		int fact = 1;
		for(int i = num1;i>0;i--)
		{
			memoria = (fact = fact*i);
		}
	}
	
	public void borrar()
	{
		memoria = 0;
	}
	
}