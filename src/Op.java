public class Op {
    int result;

    int calc(int a1, char res, int a2) throws Exception {

            switch (res) {
                case '+':
                    result = a1 + a2;
                    break;
                case '-':
                    result = a1 - a2;
                    break;
                case '*':
                    result = a1 * a2;
                    break;
                case '/':
                    result = a1 / a2;
                    break;
                default:
                    throw new Exception("Неверный оператор");
            }
        return result;
    }

}
