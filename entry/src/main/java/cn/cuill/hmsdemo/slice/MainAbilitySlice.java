package cn.cuill.hmsdemo.slice;






import cn.cuill.hmsdemo.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Text;
import ohos.global.resource.NotExistException;
import ohos.global.resource.ResourceManager;
import ohos.global.resource.WrongTypeException;

import java.io.IOException;
import java.time.Instant;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        ResourceManager resourceManager = this.getResourceManager();

        try {
            String strTitle = resourceManager.getElement(ohos.global.systemres.ResourceTable.String_request_location_reminder_title).getString();
            Text text =(Text) findComponentById(ResourceTable.Id_text);
            text.setText(strTitle);
        } catch (Exception e) {
            e.printStackTrace();
        }




        Button button = (Button) findComponentById(ResourceTable.Id_button);
        // 点击按钮跳转至第二个页面
        //button.setClickedListener(listener -> present(new SecondAbilitySlice(), new Intent()));
        button.setClickedListener(component -> {
            //点击按钮后，会执行这里的代码，跳转页面
            //跳转到的目的地
            Intent intent1 = new Intent();
            Operation operation = new Intent.OperationBuilder()
                    .withDeviceId("") //方法确定跳转的目的设备，“”表示本机
                    .withBundleName("cn.cuill.hmsdemo") //跳转的目标页面所在的应用
                    .withAbilityName(".SecondAbility")
                    .build();
            intent1.setOperation(operation);
            //调用一个方式，实现我们从MainAbility跳转到SecondAbility
            startAbility(intent1);
        });


    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
