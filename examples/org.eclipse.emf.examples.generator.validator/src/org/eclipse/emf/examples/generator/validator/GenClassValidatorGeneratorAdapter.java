/**
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 */
package org.eclipse.emf.examples.generator.validator;

import java.util.List;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;

public class GenClassValidatorGeneratorAdapter extends GenBaseGeneratorAdapter
{
  protected static final int VALIDATOR_ID = 0;

  protected static final JETEmitterDescriptor[] JET_EMITTER_DESCRIPTORS =
  {
    new JETEmitterDescriptor("model/Validator.javajet", "org.eclipse.emf.examples.generator.validator.templates.model.Validator")
  };

  protected JETEmitterDescriptor[] getJETEmitterDescriptors()
  {
    return JET_EMITTER_DESCRIPTORS;
  }

  public GenClassValidatorGeneratorAdapter()
  {
    super();
  }

  public GenClassValidatorGeneratorAdapter(GeneratorAdapterFactory generatorAdapterFactory)
  {
    super(generatorAdapterFactory);
  }

  @Override
  public boolean canGenerate(Object object, Object projectType)
  {
    return MODEL_PROJECT_TYPE.equals(projectType) ? super.canGenerate(object, projectType) : false;
  }

  @Override
  protected Diagnostic generateModel(Object object, Monitor monitor)
  {
    GenClass genClass = (GenClass)object;

    monitor.beginTask("", 2);
    message = ValidatorGeneratorPlugin.INSTANCE.getString("GeneratingValidator.message", new Object[] { ValidatorGeneratorUtil.getValidatorInterfaceName(genClass) });
    monitor.subTask(message);

    GenModel genModel = genClass.getGenModel();
    ensureProjectExists
      (genModel.getModelDirectory(), genClass, MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), createMonitor(monitor, 1));

    generateJava
      (genModel.getModelDirectory(),
       ValidatorGeneratorUtil.getValidationPackageName(genClass.getGenPackage()),
       ValidatorGeneratorUtil.getValidatorInterfaceName(genClass),
       getJETEmitter(getJETEmitterDescriptors(), VALIDATOR_ID),
       null,
       createMonitor(monitor, 1));           

    return Diagnostic.OK_INSTANCE;
  }

  @Override
  protected void addBaseTemplatePathEntries(List<String> templatePath)
  {
    templatePath.add(ValidatorGeneratorUtil.TEMPLATE_LOCATION);
    super.addBaseTemplatePathEntries(templatePath);
  }

  @Override
  protected void addClasspathEntries(JETEmitter jetEmitter) throws JETException
  {
    super.addClasspathEntries(jetEmitter);
    jetEmitter.addVariable(ValidatorGeneratorUtil.CLASSPATH_VARIABLE_NAME, ValidatorGeneratorPlugin.ID);
  }
}
