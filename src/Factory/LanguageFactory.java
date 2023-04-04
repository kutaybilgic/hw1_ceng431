package Factory;

import Enums.ELanguage;
import Model.Language;
import Model.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LanguageFactory {

    public Language createLanguage(){

        Random random = new Random();
        ELanguage[] languagesType = ELanguage.values();
        ELanguage randomType = languagesType[random.nextInt(languagesType.length)];
        List<Unit> unitList = new ArrayList<>();
        UnitFactory unitFactory = new UnitFactory();

        var unitNumber = random.nextInt(60, 100);

        for (int i = 0 ; i < unitNumber ; i++){
            Unit unit = unitFactory.createUnit();
            unitList.add(unit);
        }


        return switch (randomType) {
            case GERMAN, SPANISH, ITALIAN, TURKISH -> new Language(randomType, unitList);
        };
    }
}
