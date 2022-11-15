package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@SpecificHook")
	public void orangeHrmSecificHook()
	{
		System.out.println("This hooks runs only for OrangeHRM");
		System.out.println("This is specific hook");
	}
	
	@Before(order = 1)
	public void firstBeforeHook()
	{
		System.out.println("First Before Hook");
	}
	
	@Before(order = 2)
	public void secondBeforeHook()
	{
		System.out.println("Second Before Hook");
	}	
	
	
	@After(order = 2)
	public void firstAfterHook()
	{
		System.out.println("First After Hook");
	}
	
	@After(order = 1)
	public void secondAfterHook()
	{
		System.out.println("Second After Hook");
	}

}
