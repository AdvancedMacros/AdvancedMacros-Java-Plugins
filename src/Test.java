import org.luaj.vm2_v3_0_1.Globals;
import org.luaj.vm2_v3_0_1.LuaFunction;
import org.luaj.vm2_v3_0_1.LuaTable;
import org.luaj.vm2_v3_0_1.LuaValue;
import org.luaj.vm2_v3_0_1.lib.OneArgFunction;
import org.luaj.vm2_v3_0_1.lib.jse.JsePlatform;

public class Test {
	public static void main(String[] args) {
		Globals g = JsePlatform.debugGlobals();
		LuaFunction require = g.get("require").checkfunction();
		System.out.println(require);
		LuaValue v = require.call("HelloWorld");
		System.out.println(v);
		v.get("test").call();
		
	//	System.out.println(LuaValue.valueOf((String)null));
		
		//invoke vs arg#call
		LuaFunction f = new OneArgFunction() {
			@Override
			public LuaValue call(LuaValue arg) {
				System.out.println(arg.tojstring());
				return NONE;
			}
		};
		LuaTable t = new LuaTable();
		t.set(1, "U");
		t.set(2, "V");
		f.invoke(t.unpack());
		
	}
	
	
}
