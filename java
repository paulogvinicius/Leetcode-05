class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Nó "dummy" inicial para simplificar a construção da lista de resultado
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0; // Armazena o "vai um"

        // O loop continua enquanto houver elementos em l1 OU l2 OU se sobrou um carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Inicia a soma com o carry da iteração anterior

            // Adiciona o valor de l1, se existir
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next; // Avança para o próximo nó
            }

            // Adiciona o valor de l2, se existir
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next; // Avança para o próximo nó
            }

            // Calcula o novo carry (será 1 se sum >= 10, ou 0 caso contrário)
            carry = sum / 10;

            // Cria o novo nó com o dígito das unidades (sum % 10)
            current.next = new ListNode(sum % 10);
            current = current.next; // Avança o ponteiro do resultado
        }

        // Retorna o próximo nó da cabeça dummy (onde a lista real começa)
        return dummyHead.next;
    }
}
