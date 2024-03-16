package school.mjc.stage0.module1.task1;

import org.junit.jupiter.api.Test;
import school.mjc.task.verifier.test.BaseIOTest;

import static school.mjc.task.verifier.Util.parse;
import static school.mjc.task.verifier.assertion.CompilationUnitAssertion.assertThat;
import static school.mjc.task.verifier.matcher.DSL.sout;
import static school.mjc.task.verifier.matcher.DSL.stringLiteral;

class HelloWorldTest extends BaseIOTest {

    @Test
    void helloWorldTest() {
        HelloWorld.main(null);
        assertOutput("Hello World");

        var parsedCode = parse("src/main/java/school/mjc/stage0/module1/task1/HelloWorld.java");

        assertThat(parsedCode).hasSingleMainMethod(main ->
                main.hasSingle(sout().withArgument(stringLiteral("Hello World")),
                         """
                                Expected to find a single System.out.println with "Hello World" argument.
                                Please note that this check is case-sensitive.
                                """));
    }
}