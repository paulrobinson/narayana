/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2013, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.narayana.compensations.cdi.compensatable;

import org.jboss.narayana.compensations.cdi.api.TxCompensate;
import org.jboss.narayana.compensations.cdi.api.TxConfirm;
import org.jboss.narayana.compensations.cdi.api.TxLogged;
import org.jboss.narayana.compensations.cdi.common.DummyCompensationHandler1;
import org.jboss.narayana.compensations.cdi.common.DummyCompensationHandler2;
import org.jboss.narayana.compensations.cdi.common.DummyConfirmationHandler1;
import org.jboss.narayana.compensations.cdi.common.DummyConfirmationHandler2;
import org.jboss.narayana.compensations.cdi.common.DummyTransactionLoggedHandler1;
import org.jboss.narayana.compensations.cdi.common.DummyTransactionLoggedHandler2;

/**
 * @author <a href="mailto:gytis@redhat.com">Gytis Trikleris</a>
 */
public class SingleService {

    @TxCompensate(DummyCompensationHandler1.class)
    @TxConfirm(DummyConfirmationHandler1.class)
    @TxLogged(DummyTransactionLoggedHandler1.class)
    public void testSingle1(Throwable throwable) throws Throwable {

        if (throwable != null) {
            throw throwable;
        }
    }

    @TxCompensate(DummyCompensationHandler2.class)
    @TxConfirm(DummyConfirmationHandler2.class)
    @TxLogged(DummyTransactionLoggedHandler2.class)
    public void testSingle2(Throwable throwable) throws Throwable {

        if (throwable != null) {
            throw throwable;
        }
    }

}
