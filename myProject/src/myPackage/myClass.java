//Script para comparar el titulo de la pagina con un String definido en el codigo

package myPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class myClass {

	public static void main(String[] args) {
		
		//declaracion e instanciacion de objetos
		WebDriver driver = new FirefoxDriver();
		//String baseUrl = "http://newtours.demoaut.com";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";
		
		//Ejecutar FF y dirigirlo a la url base
		//driver.get(baseUrl);
		driver.get("http://newtours.demoaut.com");
		
		//Obtener el valor actual del titulo
		actualTitle = driver.getTitle();
		
		/*
		 * Comparar el titulo actual con el titulo esperado
		 * e imprimir el resultado como "Passed" o "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle)){
			System.out.println("Test Passed!");
			System.out.println(actualTitle);
		} else {
			System.out.println("Test Failed!");
		}
		//Cerrar firefox
		driver.close();
		//salir del programa explicitamente
		System.exit(0);
	}
}
