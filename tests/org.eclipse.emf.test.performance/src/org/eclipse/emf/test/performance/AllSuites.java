/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
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
 * $Id: AllSuites.java,v 1.11 2005/03/18 22:54:31 bportier Exp $
 */
package org.eclipse.emf.test.performance;


import junit.framework.Test;
import junit.framework.TestSuite;


public class AllSuites extends TestSuite
{
  private static Test[] suites = new Test []
  {
  //org.eclipse.emf.test.performance.serialization.AttributeTest.suite(),  

      org.eclipse.emf.test.performance.serialization.DynamicIpo.suite(),
      org.eclipse.emf.test.performance.serialization.StaticIpo.suite(),
  
      org.eclipse.emf.test.performance.deserialization.DynamicIpoLoad.suite(),
      org.eclipse.emf.test.performance.deserialization.StaticIpoLoad.suite(),
  
      org.eclipse.emf.test.performance.sdo.serialization.DynamicIPOSDOSaveTest.suite(),
      org.eclipse.emf.test.performance.sdo.serialization.StaticIPOSDOSaveTest.suite(),
  
      org.eclipse.emf.test.performance.sdo.deserialization.DynamicIPOSDOLoadTest.suite(),
      org.eclipse.emf.test.performance.sdo.deserialization.StaticIPOSDOLoadTest.suite(),
  //
//  org.eclipse.emf.test.performance.sdo.extendedMetaData.OpenContentTest.suite(),
  //
      org.eclipse.emf.test.performance.sdo.accessor.StaticSequenceTest.suite(),
  
      org.eclipse.emf.test.performance.sdo.accessor.StaticBidirectionalTest.suite()
  //
//      org.eclipse.emf.test.performance.sdo.accessor.DynamicIPOSDOAccessorTest.suite(),
//      org.eclipse.emf.test.performance.sdo.accessor.StaticIPOSDOAccessorTest.suite()
  };

  public static Test suite()
  {
    return new AllSuites("EMF Performance JUnit Test Suite");
  }

  public AllSuites()
  {
    super();
    populateSuite();
  }

  public AllSuites(Class theClass)
  {
    super(theClass);
    populateSuite();
  }

  public AllSuites(String name)
  {
    super(name);
    populateSuite();
  }

  protected void populateSuite()
  {
    for (int i = 0; i < suites.length; i++)
    {
      addTest(suites[i]);
    }
  }
}