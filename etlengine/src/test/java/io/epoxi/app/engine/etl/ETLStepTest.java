package io.epoxi.app.engine.etl;

import io.epoxi.app.engine.EngineTestDataFactory;
import io.epoxi.app.repository.model.Ingestion;
import io.epoxi.app.repository.model.KeysetId;
import io.epoxi.app.repository.model.StepType;
import io.epoxi.app.repository.TestConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ETLStepTest {

    public ETLStepTest() {
    }

    @BeforeAll
    public static void setup() {
        clean();
        init();
    }

    @AfterAll
    public static void tearDown() {

    }

    @Test
    public void getETLStep() {

        EngineTestDataFactory factory = new EngineTestDataFactory(TestConfig.etlTestAccountName);

        KeysetId keysetId = KeysetId.of("warehouse-277017", "Firm_Data_Entity");
        Ingestion ingestion = factory.getTestIngestion(keysetId);
        ETLStep step = new ETLStep(ingestion, StepType.EXTRACT);

        assertNotNull(step, "The ETLStep was successfully created");
    }



    private static void clean() {


    }

    private static void init() {
        EngineTestDataFactory.init();
    }
}
