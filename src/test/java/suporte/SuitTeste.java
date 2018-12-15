package suporte;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import estudo.CRCriar;
import estudo.CRPagar;

@RunWith(Suite.class)
@SuiteClasses({CRCriar.class,CRPagar.class})
public class SuitTeste {

}
