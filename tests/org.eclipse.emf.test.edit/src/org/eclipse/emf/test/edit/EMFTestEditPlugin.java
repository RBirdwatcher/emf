/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
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
 * $Id: EMFTestEditPlugin.java,v 1.4 2005/06/08 06:20:57 nickb Exp $
 */
package org.eclipse.emf.test.edit;

import org.eclipse.core.runtime.Plugin;

public class EMFTestEditPlugin 
extends Plugin
{
    private static EMFTestEditPlugin instance;
    
    public EMFTestEditPlugin()
    {
        super();
        instance = this;
    }

    public static EMFTestEditPlugin getPlugin()
    {
        return instance;
    }
}