package school.mjc.stage0.module1.task2;

import org.junit.jupiter.api.Test;
import school.mjc.task.verifier.test.BaseIOTest;

import static school.mjc.task.verifier.Util.parse;
import static school.mjc.task.verifier.assertion.CompilationUnitAssertion.assertThat;
import static school.mjc.task.verifier.matcher.DSL.multilineComment;

class MultiLineCommentsTest extends BaseIOTest {

    @Test
    void helloWorldTest() {
        var parsedCode = parse("src/main/java/school/mjc/stage0/module1/task2/MultiLineComments.java");

        assertThat(parsedCode).hasSingleMainMethod(main -> main.hasSingle(multilineComment(
                "This is a multiline comment.",
                "It takes 3 lines.",
                "And none of them executes.")));
    }
}
