export class Comment {
    comment_id: number;
    text: string;

    static cloneBase( comment: Comment):  Comment {
        const clonedComment: Comment = new  Comment();
        clonedComment.comment_id = comment.comment_id;
        clonedComment.text = comment.text;
        return clonedComment;
    }
}
