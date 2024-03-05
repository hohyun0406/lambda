package common;

public class UtilServiceImpl implements common.UtilService {
    private static common.UtilService instance = new UtilServiceImpl();
    private UtilServiceImpl(){}

    public static common.UtilService getInstance(){
        return instance;
    }

    public int createRandomInteger(int start, int gapBetweenStartAndEnd) {
        return start + (int)(Math.random() * gapBetweenStartAndEnd);
    }

    public double createRandomDouble(int start, int gapBetweenStartAndEnd) {
        return Math.round(start + (Math.random()*gapBetweenStartAndEnd)*10)/10.0;//여기 이해하고 넘어가기
    }

    public String createRandomName() {
        String[] names = {"이정재", "마동석", "송강호", "윤여정", "황정민", "정우성", "이병헌", "현 빈", "유해진", "손석구", "전도연", "손예진", "하지원", "김하늘", "송중기", "하정우", "장동건", "원 빈", "박해일", "소지섭", "김혜"
        };
        return names[createRandomInteger(0,20)];
    }

    public String createRandomTitle() {
        String[] title = {"근로자는 근로조건의 향상", "모든 국민은 법률", "모든 국민의 재산권", "국가는 대외무역을 육성", "모든 국민은 근로의 권리",
                "대통령은 조약을 체결", "헌법재판소는 법관의 자격", "국회는 의원의 자격을 심사", "형사피고인은 유죄의 판결", "공공필요에 의한 재산권"};
        return title[createRandomInteger(0,10)];
    }

    public String createRandomContent() {
        String[] content = {
                "근로자는 근로조건의 향상을 위하여 자주적인 단결권·단체교섭권 및 단체행동권을 가진다.",
                "모든 국민은 법률이 정하는 바에 의하여 납세의 의무를 진다.",
                "모든 국민의 재산권은 보장된다. 그 내용과 한계는 법률로 정한다.",
                "국가는 대외무역을 육성하며, 이를 규제·조정할 수 있다. 대통령이 궐위된 때 또는 대통령 당선자가 사망하거나 판결 기타의 사유로 그 자격을 상실한 때에는 60일 이내에 후임자를 선거한다.",
                "모든 국민은 근로의 권리를 가진다. 국가는 사회적·경제적 방법으로 근로자의 고용의 증진과 적정임금의 보장에 노력하여야 하며, 법률이 정하는 바에 의하여 최저임금제를 시행하여야 한다.",
                "대통령은 조약을 체결·비준하고, 외교사절을 신임·접수 또는 파견하며, 선전포고와 강화를 한다.",
                "헌법재판소는 법관의 자격을 가진 9인의 재판관으로 구성하며, 재판관은 대통령이 임명한다.",
                "국회는 의원의 자격을 심사하며, 의원을 징계할 수 있다. 대법관의 임기는 6년으로 하며, 법률이 정하는 바에 의하여 연임할 수 있다.",
                "형사피고인은 유죄의 판결이 확정될 때까지는 무죄로 추정된다.",
                "공공필요에 의한 재산권의 수용·사용 또는 제한 및 그에 대한 보상은 법률로써 하되, 정당한 보상을 지급하여야 한다."
        };
        return content[createRandomInteger(0, 10)];
    }

    @Override
    public String createRandomCompany() {
        String[] companies = {"구글","엔비디아","메타", "삼성", "LG", "애플"};
        return companies[createRandomInteger(0,6)];
    }

    @Override
    public String createRandomUsername() {
        String username = "";
        for(;
            username.length() < 5;
            username += String.valueOf((char)('a' + this.createRandomInteger(0, 26)))); //'a'는 유니코드 97값 + 랜덤수
        return username;
    }

}
