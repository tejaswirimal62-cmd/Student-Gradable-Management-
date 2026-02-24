import java.io.*;
import java.util.*;
interface Grading {
    char calculateGrade();
}

interface Storable {
    void saveData();
    void loadData();
}