package school.mjc.stage0.module1.task2;

import org.junit.jupiter.api.Test;
import school.mjc.task.verifier.test.BaseIOTest;

import static school.mjc.task.verifier.Util.parse;
import static school.mjc.task.verifier.assertion.CompilationUnitAssertion.assertThat;
import static school.mjc.task.verifier.matcher.DSL.*;

class SingleLineCommentsTest extends BaseIOTest {

    @Test
    void helloWorldTest() {
        var parsedCode = parse("src/main/java/school/mjc/stage0/module1/task2/SingleLineComments.java");

        assertThat(parsedCode).hasSingleMainMethod(main -> {
            main.hasSingle(lineComment("comment 1"));
            main.hasSingle(lineComment("comment 2"));
            main.hasSingle(lineComment("comment 3"));
        });
    }
}