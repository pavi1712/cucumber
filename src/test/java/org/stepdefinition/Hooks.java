package org.stepdefinition;

import org.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	
	@Before
	public void bfr() {
		System.out.println("Start");
		}
	
	@After
	
	public void after() {
	System.out.println("close");

	}
	@Before(order=3)
	public void bfr3() {
		System.out.println("before3");

	}
	@Before(order=1)
	public void bfr1() {
		System.out.println("before1");

	}
	@Before(order=2)
	public void bfr2() {
		System.out.println("before2");
		}
	
	@After(order=3)
	public void after1() {
		System.out.println("after1");
		}
	@After(order=1)
	public void after3() {
		System.out.println("after3");
		}
	@After(order=2)
	public void after2() {
		System.out.println("after2");
		}
	
	
	

}

