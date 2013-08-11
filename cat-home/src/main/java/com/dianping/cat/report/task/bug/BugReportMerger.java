package com.dianping.cat.report.task.bug;

import java.util.List;

import com.dianping.cat.home.bug.entity.BugReport;
import com.dianping.cat.home.bug.entity.Domain;
import com.dianping.cat.home.bug.entity.ExceptionItem;
import com.dianping.cat.home.bug.transform.DefaultMerger;

public class BugReportMerger extends DefaultMerger {

	public BugReportMerger(BugReport bugReport) {
		super(bugReport);
	}

	@Override
	protected void mergeBugReport(BugReport old, BugReport bugReport) {
		old.setStartTime(bugReport.getStartTime());
		old.setEndTime(bugReport.getEndTime());
		old.setDomain(bugReport.getDomain());
		super.mergeBugReport(old, bugReport);
	}

	@Override
	protected void mergeDomain(Domain old, Domain domain) {
		super.mergeDomain(old, domain);
	}

	@Override
	protected void mergeExceptionItem(ExceptionItem old, ExceptionItem exceptionItem) {
		old.setCount(old.getCount() + exceptionItem.getCount());
		old.getMessages().addAll(exceptionItem.getMessages());

		List<String> oldMessages = old.getMessages();
		
		if (oldMessages.size() > 10) {
			oldMessages = oldMessages.subList(0, 10);
		}

	}

}
