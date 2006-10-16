/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EXTLibraryModelWizard.java,v 1.3 2006/10/16 03:31:24 davidms Exp $
 */
package org.eclipse.emf.examples.extlibrary.presentation;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.xmi.XMLResource;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import org.eclipse.ui.actions.WorkspaceModifyOperation;

import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.provider.EXTLibraryEditPlugin;

import org.eclipse.core.runtime.Path;


import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EXTLibraryModelWizard extends Wizard implements INewWizard
{
  /**
   * This caches an instance of the model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EXTLibraryPackage extLibraryPackage = EXTLibraryPackage.eINSTANCE;

  /**
   * This caches an instance of the model factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EXTLibraryFactory extLibraryFactory = extLibraryPackage.getEXTLibraryFactory();

  /**
   * This is the file creation page.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EXTLibraryModelWizardNewFileCreationPage newFileCreationPage;

  /**
   * This is the initial object creation page.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EXTLibraryModelWizardInitialObjectCreationPage initialObjectCreationPage;

  /**
   * Remember the selection during initialization for populating the default container.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IStructuredSelection selection;

  /**
   * Remember the workbench during initialization.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IWorkbench workbench;

  /**
   * Caches the names of the types that can be created as the root object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected List initialObjectNames;

  /**
   * This just records the information.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void init(IWorkbench workbench, IStructuredSelection selection)
  {
    this.workbench = workbench;
    this.selection = selection;
    setWindowTitle(EXTLibraryEditorPlugin.INSTANCE.getString("_UI_Wizard_label")); //$NON-NLS-1$
    setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(EXTLibraryEditorPlugin.INSTANCE.getImage("full/wizban/NewEXTLibrary"))); //$NON-NLS-1$
  }

  /**
   * Returns the names of the types that can be created as the root object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Collection getInitialObjectNames()
  {
    if (initialObjectNames == null)
    {
      initialObjectNames = new ArrayList();
      for (Iterator classifiers = extLibraryPackage.getEClassifiers().iterator(); classifiers.hasNext(); )
      {
        EClassifier eClassifier = (EClassifier)classifiers.next();
        if (eClassifier instanceof EClass)
        {
          EClass eClass = (EClass)eClassifier;
          if (!eClass.isAbstract())
          {
            initialObjectNames.add(eClass.getName());
          }
        }
      }
      Collections.sort(initialObjectNames, java.text.Collator.getInstance());
    }
    return initialObjectNames;
  }

  /**
   * Create a new model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EObject createInitialModel()
  {
    EClass eClass = (EClass)extLibraryPackage.getEClassifier(initialObjectCreationPage.getInitialObjectName());
    EObject rootObject = extLibraryFactory.create(eClass);
    return rootObject;
  }

  /**
   * Do the work after everything is specified.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean performFinish()
  {
    try
    {
      // Remember the file.
      //
      final IFile modelFile = getModelFile();

      // Do the work within an operation.
      //
      WorkspaceModifyOperation operation =
        new WorkspaceModifyOperation()
        {
          protected void execute(IProgressMonitor progressMonitor)
          {
            try
            {
              // Create a resource set
              //
              ResourceSet resourceSet = new ResourceSetImpl();

              // Get the URI of the model file.
              //
              URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

              // Create a resource for this file.
              //
              Resource resource = resourceSet.createResource(fileURI);

              // Add the initial model object to the contents.
              //
              EObject rootObject = createInitialModel();
              if (rootObject != null)
              {
                resource.getContents().add(rootObject);
              }

              // Save the contents of the resource to the file system.
              //
              Map options = new HashMap();
              options.put(XMLResource.OPTION_ENCODING, initialObjectCreationPage.getEncoding());
              resource.save(options);
            }
            catch (Exception exception)
            {
              EXTLibraryEditorPlugin.INSTANCE.log(exception);
            }
            finally
            {
              progressMonitor.done();
            }
          }
        };

      getContainer().run(false, false, operation);

      // Select the new file resource in the current view.
      //
      IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
      IWorkbenchPage page = workbenchWindow.getActivePage();
      final IWorkbenchPart activePart = page.getActivePart();
      if (activePart instanceof ISetSelectionTarget)
      {
        final ISelection targetSelection = new StructuredSelection(modelFile);
        getShell().getDisplay().asyncExec
          (new Runnable()
           {
             public void run()
             {
               ((ISetSelectionTarget)activePart).selectReveal(targetSelection);
             }
           });
      }

      // Open an editor on the new file.
      //
      try
      {
        page.openEditor
          (new FileEditorInput(modelFile),
           workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
      }
      catch (PartInitException exception)
      {
        MessageDialog.openError(workbenchWindow.getShell(), EXTLibraryEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage()); //$NON-NLS-1$
        return false;
      }

      return true;
    }
    catch (Exception exception)
    {
      EXTLibraryEditorPlugin.INSTANCE.log(exception);
      return false;
    }
  }

  /**
   * This is the one page of the wizard.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public class EXTLibraryModelWizardNewFileCreationPage extends WizardNewFileCreationPage
  {
    /**
     * Pass in the selection.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EXTLibraryModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection)
    {
      super(pageId, selection);
    }

    /**
     * The framework calls this to see if the file is correct.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected boolean validatePage()
    {
      if (super.validatePage())
      {
        // Make sure the file ends in ".extlibrary".
        //
        String requiredExt = EXTLibraryEditorPlugin.INSTANCE.getString("_UI_EXTLibraryEditorFilenameExtension"); //$NON-NLS-1$
        String enteredExt = new Path(getFileName()).getFileExtension();
        if (enteredExt == null || !enteredExt.equals(requiredExt))
        {
          setErrorMessage(EXTLibraryEditorPlugin.INSTANCE.getString("_WARN_FilenameExtension", new Object [] { requiredExt })); //$NON-NLS-1$
          return false;
        }
        else
        {
          return true;
        }
      }
      else
      {
        return false;
      }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IFile getModelFile()
    {
      return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
    }
  }

  /**
   * This is the page where the type of object to create is selected.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public class EXTLibraryModelWizardInitialObjectCreationPage extends WizardPage
  {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Combo initialObjectField;

    /**
     * @generated
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    protected List encodings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Combo encodingField;

    /**
     * Pass in the selection.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EXTLibraryModelWizardInitialObjectCreationPage(String pageId)
    {
      super(pageId);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createControl(Composite parent)
    {
      Composite composite = new Composite(parent, SWT.NONE);
      {
        GridLayout layout = new GridLayout();
        layout.numColumns = 1;
        layout.verticalSpacing = 12;
        composite.setLayout(layout);

        GridData data = new GridData();
        data.verticalAlignment = GridData.FILL;
        data.grabExcessVerticalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        composite.setLayoutData(data);
      }

      Label containerLabel = new Label(composite, SWT.LEFT);
      {
        containerLabel.setText(EXTLibraryEditorPlugin.INSTANCE.getString("_UI_ModelObject")); //$NON-NLS-1$

        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        containerLabel.setLayoutData(data);
      }

      initialObjectField = new Combo(composite, SWT.BORDER);
      {
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.grabExcessHorizontalSpace = true;
        initialObjectField.setLayoutData(data);
      }

      for (Iterator i = getInitialObjectNames().iterator(); i.hasNext(); )
      {
        initialObjectField.add(getLabel((String)i.next()));
      }

      if (initialObjectField.getItemCount() == 1)
      {
        initialObjectField.select(0);
      }
      initialObjectField.addModifyListener(validator);

      Label encodingLabel = new Label(composite, SWT.LEFT);
      {
        encodingLabel.setText(EXTLibraryEditorPlugin.INSTANCE.getString("_UI_XMLEncoding")); //$NON-NLS-1$

        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        encodingLabel.setLayoutData(data);
      }
      encodingField = new Combo(composite, SWT.BORDER);
      {
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.grabExcessHorizontalSpace = true;
        encodingField.setLayoutData(data);
      }

      for (Iterator i = getEncodings().iterator(); i.hasNext(); )
      {
        encodingField.add((String)i.next());
      }

      encodingField.select(0);
      encodingField.addModifyListener(validator);

      setPageComplete(validatePage());
      setControl(composite);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModifyListener validator =
      new ModifyListener()
      {
        public void modifyText(ModifyEvent e)
        {
          setPageComplete(validatePage());
        }
      };

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected boolean validatePage()
    {
      return getInitialObjectName() != null && getEncodings().contains(encodingField.getText());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVisible(boolean visible)
    {
      super.setVisible(visible);
      if (visible)
      {
        if (initialObjectField.getItemCount() == 1)
        {
          initialObjectField.clearSelection();
          encodingField.setFocus();
        }
        else
        {
          encodingField.clearSelection();
          initialObjectField.setFocus();
        }
      }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInitialObjectName()
    {
      String label = initialObjectField.getText();

      for (Iterator i = getInitialObjectNames().iterator(); i.hasNext(); )
      {
        String name = (String)i.next();
        if (getLabel(name).equals(label))
        {
          return name;
        }
      }
      return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEncoding()
    {
      return encodingField.getText();
    }

    /**
     * Returns the label for the specified type name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected String getLabel(String typeName)
    {
      try
      {
        return EXTLibraryEditPlugin.INSTANCE.getString("_UI_" + typeName + "_type"); //$NON-NLS-1$ //$NON-NLS-2$
      }
      catch(MissingResourceException mre)
      {
        EXTLibraryEditorPlugin.INSTANCE.log(mre);
      }
      return typeName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection getEncodings()
    {
      if (encodings == null)
      {
        encodings = new ArrayList();
        for (StringTokenizer stringTokenizer = new StringTokenizer(EXTLibraryEditorPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens(); ) //$NON-NLS-1$
        {
          encodings.add(stringTokenizer.nextToken());
        }
      }
      return encodings;
    }
  }

  /**
   * The framework calls this to create the contents of the wizard.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void addPages()
  {
    // Create a page, set the title, and the initial model file name.
    //
    newFileCreationPage = new EXTLibraryModelWizardNewFileCreationPage("Whatever", selection); //$NON-NLS-1$
    newFileCreationPage.setTitle(EXTLibraryEditorPlugin.INSTANCE.getString("_UI_EXTLibraryModelWizard_label")); //$NON-NLS-1$
    newFileCreationPage.setDescription(EXTLibraryEditorPlugin.INSTANCE.getString("_UI_EXTLibraryModelWizard_description")); //$NON-NLS-1$
    newFileCreationPage.setFileName(EXTLibraryEditorPlugin.INSTANCE.getString("_UI_EXTLibraryEditorFilenameDefaultBase") + "." + EXTLibraryEditorPlugin.INSTANCE.getString("_UI_EXTLibraryEditorFilenameExtension")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    addPage(newFileCreationPage);

    // Try and get the resource selection to determine a current directory for the file dialog.
    //
    if (selection != null && !selection.isEmpty())
    {
      // Get the resource...
      //
      Object selectedElement = selection.iterator().next();
      if (selectedElement instanceof IResource)
      {
        // Get the resource parent, if its a file.
        //
        IResource selectedResource = (IResource)selectedElement;
        if (selectedResource.getType() == IResource.FILE)
        {
          selectedResource = selectedResource.getParent();
        }

        // This gives us a directory...
        //
        if (selectedResource instanceof IFolder || selectedResource instanceof IProject)
        {
          // Set this for the container.
          //
          newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

          // Make up a unique new name here.
          //
          String defaultModelBaseFilename = EXTLibraryEditorPlugin.INSTANCE.getString("_UI_EXTLibraryEditorFilenameDefaultBase"); //$NON-NLS-1$
          String defaultModelFilenameExtension = EXTLibraryEditorPlugin.INSTANCE.getString("_UI_EXTLibraryEditorFilenameExtension"); //$NON-NLS-1$
          String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension; //$NON-NLS-1$
          for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i)
          {
            modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension; //$NON-NLS-1$
          }
          newFileCreationPage.setFileName(modelFilename);
        }
      }
    }
    initialObjectCreationPage = new EXTLibraryModelWizardInitialObjectCreationPage("Whatever2"); //$NON-NLS-1$
    initialObjectCreationPage.setTitle(EXTLibraryEditorPlugin.INSTANCE.getString("_UI_EXTLibraryModelWizard_label")); //$NON-NLS-1$
    initialObjectCreationPage.setDescription(EXTLibraryEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description")); //$NON-NLS-1$
    addPage(initialObjectCreationPage);
  }

  /**
   * Get the file from the page.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IFile getModelFile()
  {
    return newFileCreationPage.getModelFile();
  }

}
