package interfaces;

/**
 * ��������� �������� ��������� ������ ��-0901 ���������� ������� 2013�.
 *
 * ���� ��������� ��������� ������, ������� ����� ���� ����������
 * � �������� �������� MD5 ���� ��� ����� � �������.
 */
public interface MD5CalculatorStateListener {
    
    /**
     * ���� ����� ����������, ���� ����� ������� ������� ���������
     * ����� � ������ � ��� (����������� ������ ������, �����������
     * �� ������ ������� � �.�.)
     */
    public void folderStructureAnalyseBegin();
    
    /**
     * ���� ����� ���������� ����� ���������� ������� ��������� �����.
     * � �������� ���������� �������� ���������� �������.
     * 
     *  folderCount ���������� �����
     *  filesCount ���������� ������
     *  filesSize ����� ������ ������
     */
    public void folderStructureAnalyseEnd(int folderCount,
            int filesCount, long filesSize);
    
    /**
     * ���� ����� ���������� ����� ������� �������� MD5 �����
     * ���������� �����
     * fileName ��� �����
     * fileLength ����� �����
     */
    public void MD5SumCalculationBegin(String fileName, long fileLength);
    
    /**
     * ���� ����� ���������� ����� ��������� �������� MD5 �����
     * ���������� �����
     * fileName ��� �����
     */
    public void MD5SumCalculationEnd(String fileName);
}
