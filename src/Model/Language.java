package Model;

import Enums.ELanguage;
import Enums.ELeagueType;

import java.util.List;

public class Language {

    private ELanguage languageName;

    private List<Unit> unitList;

    private Integer currentUnit;

    private Integer totalPoint;

    public Language(ELanguage languageName, List<Unit> unitList) {
        this.languageName = languageName;
        this.unitList = unitList;
        this.currentUnit = 0;
        this.totalPoint = 0;
    }

    public Integer getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
    }

    public Integer getCurrentUnit() {
        return currentUnit;
    }

    public void setCurrentUnit(Integer currentUnit) {
        this.currentUnit = currentUnit;
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
