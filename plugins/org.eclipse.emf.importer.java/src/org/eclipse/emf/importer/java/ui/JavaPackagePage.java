/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: JavaPackagePage.java,v 1.3 2005/05/12 17:09:33 marcelop Exp $
 */
package org.eclipse.emf.importer.java.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import org.eclipse.emf.importer.ModelImporter;
import org.eclipse.emf.importer.java.JavaImporter;
import org.eclipse.emf.importer.java.JavaImporterPlugin;
import org.eclipse.emf.importer.ui.contribution.base.ModelPackagePage;


/**
 * @since 2.1.0
 */
public class JavaPackagePage extends ModelPackagePage
{
  public JavaPackagePage(ModelImporter modelImporter, String pageName)
  {
    super(modelImporter, pageName);
  }

  public JavaImporter getJavaImporter()
  {
    return (JavaImporter)getModelImporter();
  }

  protected void pageActivated(final boolean firstTime, int cause)
  {
    if (getJavaImporter().canImport())
    {
      setErrorMessage(null);
      getControl().getDisplay().asyncExec(new Runnable()
        {
          public void run()
          {
            computeEPackages();
            filterPackagesTable(firstTime);
            getContainer().updateButtons();
          }
        });
    }
    else
    {
      setErrorMessage(JavaImporterPlugin.INSTANCE.getString("_UI_JavaProjectRequired_message"));
      setPageComplete(false);
    }
  }

  protected void computeEPackages()
  {
    WorkspaceModifyOperation initializeOperation = new WorkspaceModifyOperation()
      {
        protected void execute(IProgressMonitor progressMonitor) throws CoreException
        {
          try
          {
            computeEPackages(progressMonitor);
          }
          catch (Exception e)
          {
            JavaImporterPlugin.INSTANCE.log(e);
          }
          finally
          {
            progressMonitor.done();
          }
        }
      };

    try
    {
      getContainer().run(false, false, initializeOperation);
    }
    catch (Exception exception)
    {
      JavaImporterPlugin.INSTANCE.log(exception);
    }
  }

  protected void computeEPackages(IProgressMonitor progressMonitor) throws Exception
  {
    IStatus status = getJavaImporter().computeEPackages(progressMonitor);
    if (!status.isOK())
    {
      ErrorDialog.openError(
        getShell(),
        JavaImporterPlugin.INSTANCE.getString("_UI_LoadProblem_title"),
        JavaImporterPlugin.INSTANCE.getString("_UI_ProblemsEncounteredProcessingJava_message"),
        status);
    }
  }
}
