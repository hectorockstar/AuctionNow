package com.auctionnow.scheduling;


import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QueuePoolerJob extends QuartzJobBean{
 
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    	Map jobsExecutions = jobExecutionContext.getJobDetail().getJobDataMap();
    	
    	if (jobsExecutions != null && !jobsExecutions.isEmpty()) {
	    	jobsExecutions.forEach((k,v)-> {
	    		((IAuctionNowJobExecution)v).doInTransaction();
	    	});
    	}
    	
    }
 
    
}