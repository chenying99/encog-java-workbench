/*
 * Encog(tm) Workbanch v3.1 - Java Version
 * http://www.heatonresearch.com/encog/
 * http://code.google.com/p/encog-java/
 
 * Copyright 2008-2012 Heaton Research, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *   
 * For more information on Heaton Research copyrights, licenses 
 * and trademarks visit:
 * http://www.heatonresearch.com/copyright
 */
package org.encog.workbench.dialogs.wizard.generate;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import org.encog.app.generate.TargetLanguage;
import org.encog.workbench.EncogWorkBench;
import org.encog.workbench.dialogs.common.CheckField;
import org.encog.workbench.dialogs.common.ComboBoxField;
import org.encog.workbench.dialogs.common.EncogPropertiesDialog;
import org.encog.workbench.dialogs.common.TextField;

public class CodeGenerateDialog extends EncogPropertiesDialog {
	
	private final ComboBoxField target;
	
	private final List<String> methods = new ArrayList<String>();
	
	public CodeGenerateDialog() {
		super(EncogWorkBench.getInstance().getMainWindow());
		
		List<String> targets = new ArrayList<String>();
		targets.add("Java");
		targets.add("JavaScript");
		targets.add("CSharp");
		targets.add("MQL4");
		targets.add("NinjaScript");
				
				
		this.setSize(640, 360);
		this.setTitle("Code Generation");
		
		beginTab("Data");
		addProperty(this.target = new ComboBoxField("target","Target Platform",true,targets));
		
		render();
	
		((JComboBox)this.target.getField()).setSelectedIndex(0);
	}

	public TargetLanguage getTargetLanguage() {
		switch( this.target.getSelectedIndex() ) {
			case 0:
				return TargetLanguage.Java;
			case 1:
				return TargetLanguage.JavaScript;
			case 2:
				return TargetLanguage.CSharp;
			case 3:
				return TargetLanguage.MQL4;
			case 4:
				return TargetLanguage.NinjaScript;
			default:
				return TargetLanguage.Java;
		}
	}
	

	
	
}
