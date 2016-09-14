package javacourse.ocp.dataformat.resourcebundles;


import java.util.ListResourceBundle;

public class ExampleBundle_es_ES extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {

		return new Object[][] {
			{"title", "title from ExampleBundle_es_ES.java"}
		};
	}
}