package autobuska_stanica.gui;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import autobuska_stanica.AutobuskaStanica;
import test.TestUtil;

public class AutobuskaStanicaGUITest {

	private AutobuskaStanicaGUI instance;

	@Before
	public void setUp() throws Exception {
		instance = new AutobuskaStanicaGUI();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void atribut_stanica() {
		assertTrue("U klasi nije definisan atribut stanica", TestUtil.doesFieldExist(AutobuskaStanicaGUI.class, "stanica"));
	}
	
	@Test
	public void atribut_stanica_vidljivost() {
		assertTrue("Atribut stanica nije privatan", TestUtil.hasFieldModifier(AutobuskaStanicaGUI.class, "stanica", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_stanica_pocetnaVrednost() {
		AutobuskaStanica stanica = (AutobuskaStanica) TestUtil.getFieldValue(instance, "stanica");
		
		assertNotNull("Atribut stanica nije inicijalizovan", stanica);
	}
}
