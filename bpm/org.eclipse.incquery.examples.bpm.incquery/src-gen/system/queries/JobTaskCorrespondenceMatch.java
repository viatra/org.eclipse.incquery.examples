package system.queries;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import process.Task;
import system.Job;

/**
 * Pattern-specific match representation of the system.queries.JobTaskCorrespondence pattern, 
 * to be used in conjunction with {@link JobTaskCorrespondenceMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see JobTaskCorrespondenceMatcher
 * @see JobTaskCorrespondenceProcessor
 * 
 */
public abstract class JobTaskCorrespondenceMatch extends BasePatternMatch {
  private Job fJob;
  
  private Task fTask;
  
  private static List<String> parameterNames = makeImmutableList("Job", "Task");
  
  private JobTaskCorrespondenceMatch(final Job pJob, final Task pTask) {
    this.fJob = pJob;
    this.fTask = pTask;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Job".equals(parameterName)) return this.fJob;
    if ("Task".equals(parameterName)) return this.fTask;
    return null;
    
  }
  
  public Job getJob() {
    return this.fJob;
    
  }
  
  public Task getTask() {
    return this.fTask;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Job".equals(parameterName) ) {
    	this.fJob = (system.Job) newValue;
    	return true;
    }
    if ("Task".equals(parameterName) ) {
    	this.fTask = (process.Task) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setJob(final Job pJob) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fJob = pJob;
    
  }
  
  public void setTask(final Task pTask) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTask = pTask;
    
  }
  
  @Override
  public String patternName() {
    return "system.queries.JobTaskCorrespondence";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return JobTaskCorrespondenceMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fJob, fTask};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Job\"=" + prettyPrintValue(fJob) + ", ");
    result.append("\"Task\"=" + prettyPrintValue(fTask));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fJob == null) ? 0 : fJob.hashCode()); 
    result = prime * result + ((fTask == null) ? 0 : fTask.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof JobTaskCorrespondenceMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    JobTaskCorrespondenceMatch other = (JobTaskCorrespondenceMatch) obj;
    if (fJob == null) {if (other.fJob != null) return false;}
    else if (!fJob.equals(other.fJob)) return false;
    if (fTask == null) {if (other.fTask != null) return false;}
    else if (!fTask.equals(other.fTask)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return JobTaskCorrespondenceMatcher.querySpecification().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends JobTaskCorrespondenceMatch {
    Mutable(final Job pJob, final Task pTask) {
      super(pJob, pTask);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends JobTaskCorrespondenceMatch {
    Immutable(final Job pJob, final Task pTask) {
      super(pJob, pTask);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}