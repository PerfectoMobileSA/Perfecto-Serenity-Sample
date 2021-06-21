package com.perfecto;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResult;
import com.perfecto.reportium.test.result.TestResultFactory;

import net.serenitybdd.core.environment.WebDriverConfiguredEnvironment;
import net.thucydides.core.model.DataTable;
import net.thucydides.core.model.Story;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.model.TestTag;
import net.thucydides.core.steps.*;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import static net.thucydides.core.model.TestResult.FAILURE;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class PerfectoListener implements StepListener {

	ReportiumClient reportiumClient;
	Throwable exc = null;

	@Override
	public void testSuiteStarted(Class<?> aClass) {

	}

	@Override
	public void testSuiteStarted(Story story) {
		
	}

	@Override
	public void testSuiteFinished() {


	}

	@Override
	public void testStarted(String s) {
//		System.out.println(s +"is started with : "+System.getProperty("environment"));
//		String jobName = System.getProperty("reportium-job-name");
//		String jobNumber = System.getProperty("reportium-job-number");
//		String tag = System.getProperty("reportium-job-tags") != null ? System.getProperty("reportium-job-tags") : "tag";
//		PerfectoExecutionContext perfectoExecutionContext = null;
//		if(jobName!=null && jobNumber!=null) {
//			perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
//					.withProject(new Project("Perfecto Serenity Project", "1.0"))
//					.withJob(new Job(jobName, Integer.parseInt(jobNumber)))
//					.withContextTags(tag)
//					.withWebDriver(getDriver())
//					.build();
//		}else {
//			perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
//					.withProject(new Project("PerfectoSerenity Project", "1.0"))
//					//.withJob(new Job(jobName, Integer.parseInt(jobNumber)))
//					.withContextTags(tag)
//					.withWebDriver(getDriver())
//					.build();
//		}
//
//		reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
	}

	@Override
	public void testStarted(String s, String s1) {
//		new PerfectoSerenityDriver().newDriver();
//		ThucydidesWebDriverSupport.useDriver(PerfectoSerenityDriver.getDriver());
//		System.out.println(s +"is started with : "+System.getProperty("environment")+": s1 is :"+s1);
//		String jobName = System.getProperty("reportium-job-name");
//		String jobNumber = System.getProperty("reportium-job-number");
//		String tag = System.getProperty("reportium-job-tags") != null ? System.getProperty("reportium-job-tags") : "tag";
//		PerfectoExecutionContext perfectoExecutionContext = null;
//		if(jobName!=null && jobNumber!=null) {
//			perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
//					.withProject(new Project("PerfectoSerenity Project", "1.0"))
//					.withJob(new Job(jobName, Integer.parseInt(jobNumber)))
//					.withContextTags(tag)
//					.withWebDriver(getDriver())
//					.build();
//		}else {
//			perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
//					.withProject(new Project("PerfectoSerenity Project", "1.0"))
//					//.withJob(new Job(jobName, Integer.parseInt(jobNumber)))
//					.withContextTags(tag)
//					.withWebDriver(getDriver())
//					.build();
//		}
//		reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
		PerfectoSerenityDriver.getReportiumClient().testStart(s,new TestContext());

	}

	@Override
	public void testFinished(TestOutcome testOutcome) {
		System.out.println("tags: "+testOutcome.getTags());
		Collection<String> tags = new ArrayList<String>();
		Set<TestTag>testTags = testOutcome.getTags();
		for (TestTag testTag : testTags) {
			if(testTag.getType().equals("tag")) {
				tags.add(testTag.getName());
			}
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		TestContext context = new TestContext.Builder()
		.withTestExecutionTags(tags)
		.withCustomFields()
		.build();
		System.out.println("Outcome: "+testOutcome.isSuccess());
		if (testOutcome.isSuccess()) {
			PerfectoSerenityDriver.getReportiumClient().testStop(TestResultFactory.createSuccess(), context);
		}else if (testOutcome.isFailure() || testOutcome.isError() || exc!=null) {
			PerfectoSerenityDriver.getReportiumClient().testStop(TestResultFactory.createFailure(exc), context);
		}

	}

	@Override
	public void testRetried() {

	}

	@Override
	public void stepStarted(ExecutedStepDescription executedStepDescription) {
		PerfectoSerenityDriver.getReportiumClient().stepStart(executedStepDescription.getName());

	}

	@Override
	public void skippedStepStarted(ExecutedStepDescription executedStepDescription) {

	}

	@Override
	public void stepFailed(StepFailure stepFailure) {
		exc = stepFailure.getException();
	}

	@Override
	public void lastStepFailed(StepFailure stepFailure) {

	}

	@Override
	public void stepIgnored() {

	}

	@Override
	public void stepPending() {

	}

	@Override
	public void stepPending(String s) {

	}

	@Override
	public void stepFinished() {

	}

	@Override
	public void testFailed(TestOutcome testOutcome, Throwable throwable) {

	}

	@Override
	public void testIgnored() {
		
	}

	@Override
	public void testSkipped() {

	}

	@Override
	public void testPending() {

	}

	@Override
	public void testIsManual() {

	}

	@Override
	public void notifyScreenChange() {

	}

	@Override
	public void useExamplesFrom(DataTable dataTable) {

	}

	@Override
	public void addNewExamplesFrom(DataTable dataTable) {

	}

	@Override
	public void exampleStarted(Map<String, String> map) {

	}

	@Override
	public void exampleFinished() {

	}

	@Override
	public void assumptionViolated(String s) {

	}

	@Override
	public void testRunFinished() {

	}
}
