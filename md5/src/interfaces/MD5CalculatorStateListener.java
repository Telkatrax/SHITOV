package interfaces;

/**
 * Программа написана студентом группы ки-0901 Шуршиловым Артемом 2013г.
 *
 * Этот интерфейс реализуют классы, которые хотят быть уведомлены
 * о процессе рассчета MD5 сумм для папки с файлами.
 */
public interface MD5CalculatorStateListener {
    
    /**
     * Этот метод вызывается, если начат процесс анализа структуры
     * папок и файлов в них (составление списка файлов, определение
     * их общего размера и т.д.)
     */
    public void folderStructureAnalyseBegin();
    
    /**
     * Этот метод вызывается после завершения анализа структуры папок.
     * В качестве параметров получает результаты анализа.
     * 
     *  folderCount количество папок
     *  filesCount количество файлов
     *  filesSize общий размер файлов
     */
    public void folderStructureAnalyseEnd(int folderCount,
            int filesCount, long filesSize);
    
    /**
     * Этот метод вызывается перед началом рассчета MD5 суммы
     * очередного файла
     * fileName имя файла
     * fileLength длина файла
     */
    public void MD5SumCalculationBegin(String fileName, long fileLength);
    
    /**
     * Этот метод вызывается после окончания рассчета MD5 суммы
     * очередного файла
     * fileName имя файла
     */
    public void MD5SumCalculationEnd(String fileName);
}
