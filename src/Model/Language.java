package Model;

import Enums.ELanguage;
import Enums.ELeagueType;

import java.util.List;

public class Language {

    private ELanguage languageName;

    private List<Unit> unitList;

    public Language(ELanguage languageName, List<Unit> unitList) {
        this.languageName = languageName;
        this.unitList = unitList;
    }

    public ELanguage getLanguageName() {
        return languageName;
    }

    public void setLanguageName(ELanguage languageName) {
        this.languageName = languageName;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<Unit> unitList) {
        this.unitList = unitList;
    }


}
