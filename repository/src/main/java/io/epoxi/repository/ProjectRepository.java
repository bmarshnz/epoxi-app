package io.epoxi.repository;

import io.epoxi.repository.modelbase.MemberRepository;
import io.epoxi.repository.model.Project;
import io.epoxi.repository.modelbase.EngineRepository;

import io.epoxi.repository.model.Source;
import io.epoxi.repository.model.Stream;
import io.epoxi.repository.model.Target;

public class ProjectRepository extends MemberRepository<Project> {

	protected ProjectRepository(EngineRepository<?> parentRepository) {
        super(Project.class, parentRepository);	
    }    
    
    public MemberRepository<Source> getSourceRepository(Long projectId) {

		if(projectId == null) throw new IllegalArgumentException(PROJECT_ID_NOT_NULL);
		setId(projectId);
		return new MemberRepository<>(Source.class, this);
	}

	public MemberRepository<Target> getTargetRepository(Long projectId) {
        
		if(projectId == null) throw new IllegalArgumentException(PROJECT_ID_NOT_NULL);
		setId(projectId);
        return new MemberRepository<>(Target.class, this);
    }
    
    public MemberRepository<Stream> getStreamRepository(Long projectId) {
 
		if(projectId == null) throw new IllegalArgumentException(PROJECT_ID_NOT_NULL);
		setId(projectId);
		return new MemberRepository<>(Stream.class, this);
	}

	public IngestionRepository getIngestionRepository(Long projectId) {

		if(projectId == null) throw new IllegalArgumentException(PROJECT_ID_NOT_NULL);
		setId(projectId);
		return new IngestionRepository(this);
	}

	public IngestionSyncRepository getIngestionSyncRepository(Long projectId) {

		if(projectId == null) throw new IllegalArgumentException(PROJECT_ID_NOT_NULL);
		setId(projectId);
		return new IngestionSyncRepository(this);
	}
    
    public static ProjectRepository of (EngineRepository<?> parentRepository)
	{
		return new ProjectRepository(parentRepository);
	}

	static final String PROJECT_ID_NOT_NULL = "projectId must not be null";
	
}