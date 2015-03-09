/**
 * Copyright (c) 2013, Redsolution LTD. All rights reserved.
 * 
 * This file is part of Xabber project; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License, Version 3.
 * 
 * Xabber is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License,
 * along with this program. If not, see http://www.gnu.org/licenses/.
 */
package com.xabber.android.data.account;

import android.content.Intent;

import com.xabber.android.data.Application;
import com.xabber.android.data.entity.AccountRelated;
import com.xabber.android.data.notification.AccountNotificationItem;
import com.xabber.android.ui.AccountEditor;
import com.xabber.androiddev.R;

public class AccountAuthorizationError extends AccountRelated implements
		AccountNotificationItem {

	public AccountAuthorizationError(String account) {
		super(account);
	}

	@Override
	public Intent getIntent() {
		return AccountEditor.createIntent(
				Application.getInstance(), account);
	}

	@Override
	public String getTitle() {
        System.out.println("********* getTitile ");
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElements.length; i++) {
            System.out.println(stackTraceElements[i]);
        }
        System.out.println("printed array");
        System.out.println(stackTraceElements[stackTraceElements.length-1].getMethodName());
        System.out.println(Thread.currentThread().getStackTrace());
		return Application.getInstance().getString(
				R.string.AUTHENTICATION_FAILED);
	}

	@Override
	public String getText() {
		return AccountManager.getInstance().getVerboseName(account);
	}

}
