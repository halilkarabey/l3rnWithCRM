package pages;

public class AllPage {
    public AllPage() {
    }

    private StatusChecked statusChecked;
    private AcademyNameChecked academyNameChecked;
    private OverviewChecked overviewChecked;
    private SessionsAmountChecked sessionsAmountChecked;
    private PMChecked pmChecked;
    private RelatedCourses relatedCourses;
    private KeyTakeAway keyTakeAway;
    private CourseOutline courseOutline;
    private Price price;

    public StatusChecked statusChecked() {
        if (statusChecked == null) {
            statusChecked = new StatusChecked();
        }
        return statusChecked;
    }

    public OverviewChecked overviewChecked() {
        if (overviewChecked == null) {
            overviewChecked = new OverviewChecked();
        }
        return overviewChecked;
    }

    public AcademyNameChecked academyNameChecked() {
        if (academyNameChecked == null) {
            academyNameChecked = new AcademyNameChecked();
        }
        return academyNameChecked;
    }

    public SessionsAmountChecked sessionsAmountChecked() {
        if (sessionsAmountChecked == null) {
            sessionsAmountChecked = new SessionsAmountChecked();
        }
        return sessionsAmountChecked;
    }

    public PMChecked pmChecked() {
        if (pmChecked == null) {
            pmChecked = new PMChecked();
        }
        return pmChecked;
    }

    public RelatedCourses relatedCourses() {
        if (relatedCourses == null) {
            relatedCourses = new RelatedCourses();
        }
        return relatedCourses;
    }

    public KeyTakeAway keyTakeAway() {
        if (keyTakeAway == null) {
            keyTakeAway = new KeyTakeAway();
        }
        return keyTakeAway;
    }

    public CourseOutline courseOutline() {
        if (courseOutline == null) {
            courseOutline = new CourseOutline();
        }
        return courseOutline;
    }

    public Price price() {
        if (price == null) {
            price = new Price();
        }
        return price;
    }
}
