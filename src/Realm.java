import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Realm {

    private static BufferedReader br;
    private static FantasyCharacter player = null;
    private static BattleScene battleScene = null;

    public interface FightCallback {
        void fightWin();

        void fightLost();
    }

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battleScene = new BattleScene();
        System.out.println("Введите имя пользователя:");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String string) throws IOException {
        if (player == null) {
            player = new Knight(string, 100, 20, 20, 0, 0);
        }
        System.out.println(String.format("Спасти королевство от монстров вызвался %s! Да прибудет с нами сила!", player.getName()));
        printNavigation();
        switch (string) {
            case "1": {
                System.out.println("Торговец ещё не прибыл на работу");
                command(br.readLine());
            }
            break;
            case "2": {
                commitFight();
            }
            break;
            case "3":
                System.exit(1);
                break;
            case "да":
                command("2");
                break;
            case "нет": {
                printNavigation();
                command(br.readLine());
            }
        }
        command(br.readLine());
    }

    private static void printNavigation() {
        System.out.println("Куда вы желаете отправиться?");
        System.out.println("1. К торговцу");
        System.out.println("2. В тёмный лес");
        System.out.println("3. Выход");
    }

    private static void commitFight() {
        battleScene.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыты и %d золота, осталось %d здоровья",
                        player.getName(), player.getXp(), player.getGold(), player.getHealthPoints()));
                System.out.println("Хотите отправится в поход или вернуться в город? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });
    }

    private static FantasyCharacter createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0)
            return new Goblin("Гоблин", 50, 10, 10, 100, 20);
        else return new Skeleton("Скелет", 25, 20, 20, 100, 10);
    }
}