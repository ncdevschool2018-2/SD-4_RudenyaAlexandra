export class Comment {
    comment_id: number;
    name_comment: string;

    static cloneBase( comment: Comment):  Comment {
        const clonedComment: Comment = new  Comment();
        clonedComment.comment_id = comment.comment_id;
        clonedComment.name_comment = comment.name_comment;
        return clonedComment;
    }
}
