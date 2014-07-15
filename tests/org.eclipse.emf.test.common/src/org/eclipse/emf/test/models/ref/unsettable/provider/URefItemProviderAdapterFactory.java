/**
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.  This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 */
package org.eclipse.emf.test.models.ref.unsettable.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.test.models.ref.unsettable.util.URefAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class URefItemProviderAdapterFactory extends URefAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable
{
  /**
   * This keeps track of the root adapter factory that delegates to this adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComposedAdapterFactory parentAdapterFactory;

  /**
   * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IChangeNotifier changeNotifier = new ChangeNotifier();

  /**
   * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Collection<Object> supportedTypes = new ArrayList<Object>();

  /**
   * This constructs an instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URefItemProviderAdapterFactory()
  {
    supportedTypes.add(IEditingDomainItemProvider.class);
    supportedTypes.add(IStructuredItemContentProvider.class);
    supportedTypes.add(ITreeItemContentProvider.class);
    supportedTypes.add(IItemLabelProvider.class);
    supportedTypes.add(IItemPropertySource.class);
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.test.models.ref.unsettable.C1U} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected C1UItemProvider c1UItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.test.models.ref.unsettable.C1U}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createC1UAdapter()
  {
    if (c1UItemProvider == null)
    {
      c1UItemProvider = new C1UItemProvider(this);
    }

    return c1UItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.test.models.ref.unsettable.C2U} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected C2UItemProvider c2UItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.test.models.ref.unsettable.C2U}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createC2UAdapter()
  {
    if (c2UItemProvider == null)
    {
      c2UItemProvider = new C2UItemProvider(this);
    }

    return c2UItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.test.models.ref.unsettable.AU} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AUItemProvider auItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.test.models.ref.unsettable.AU}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createAUAdapter()
  {
    if (auItemProvider == null)
    {
      auItemProvider = new AUItemProvider(this);
    }

    return auItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.test.models.ref.unsettable.BU} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BUItemProvider buItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.test.models.ref.unsettable.BU}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createBUAdapter()
  {
    if (buItemProvider == null)
    {
      buItemProvider = new BUItemProvider(this);
    }

    return buItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.test.models.ref.unsettable.CU} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CUItemProvider cuItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.test.models.ref.unsettable.CU}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createCUAdapter()
  {
    if (cuItemProvider == null)
    {
      cuItemProvider = new CUItemProvider(this);
    }

    return cuItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.test.models.ref.unsettable.DU} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DUItemProvider duItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.test.models.ref.unsettable.DU}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createDUAdapter()
  {
    if (duItemProvider == null)
    {
      duItemProvider = new DUItemProvider(this);
    }

    return duItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.test.models.ref.unsettable.C4U} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected C4UItemProvider c4UItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.test.models.ref.unsettable.C4U}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createC4UAdapter()
  {
    if (c4UItemProvider == null)
    {
      c4UItemProvider = new C4UItemProvider(this);
    }

    return c4UItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.test.models.ref.unsettable.C3U} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected C3UItemProvider c3UItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.test.models.ref.unsettable.C3U}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createC3UAdapter()
  {
    if (c3UItemProvider == null)
    {
      c3UItemProvider = new C3UItemProvider(this);
    }

    return c3UItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.test.models.ref.unsettable.EU} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EUItemProvider euItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.test.models.ref.unsettable.EU}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createEUAdapter()
  {
    if (euItemProvider == null)
    {
      euItemProvider = new EUItemProvider(this);
    }

    return euItemProvider;
  }

  /**
   * This returns the root adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComposeableAdapterFactory getRootAdapterFactory()
  {
    return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
  }

  /**
   * This sets the composed adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
  {
    this.parentAdapterFactory = parentAdapterFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object type)
  {
    return supportedTypes.contains(type) || super.isFactoryForType(type);
  }

  /**
   * This implementation substitutes the factory itself as the key for the adapter.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter adapt(Notifier notifier, Object type)
  {
    return super.adapt(notifier, this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object adapt(Object object, Object type)
  {
    if (isFactoryForType(type))
    {
      Object adapter = super.adapt(object, type);
      if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter)))
      {
        return adapter;
      }
    }

    return null;
  }

  /**
   * This adds a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void addListener(INotifyChangedListener notifyChangedListener)
  {
    changeNotifier.addListener(notifyChangedListener);
  }

  /**
   * This removes a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void removeListener(INotifyChangedListener notifyChangedListener)
  {
    changeNotifier.removeListener(notifyChangedListener);
  }

  /**
   * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void fireNotifyChanged(Notification notification)
  {
    changeNotifier.fireNotifyChanged(notification);

    if (parentAdapterFactory != null)
    {
      parentAdapterFactory.fireNotifyChanged(notification);
    }
  }

  /**
   * This disposes all of the item providers created by this factory. 
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void dispose()
  {
    if (c1UItemProvider != null) c1UItemProvider.dispose();
    if (c2UItemProvider != null) c2UItemProvider.dispose();
    if (auItemProvider != null) auItemProvider.dispose();
    if (buItemProvider != null) buItemProvider.dispose();
    if (cuItemProvider != null) cuItemProvider.dispose();
    if (duItemProvider != null) duItemProvider.dispose();
    if (c4UItemProvider != null) c4UItemProvider.dispose();
    if (c3UItemProvider != null) c3UItemProvider.dispose();
    if (euItemProvider != null) euItemProvider.dispose();
  }

}
